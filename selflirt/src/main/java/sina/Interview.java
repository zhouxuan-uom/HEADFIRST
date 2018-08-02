package sina;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统计一个目录及其子目录下代码文件的行数（java），输出：
 * 总行数，总空行数，总注释行数
 * 性能越高越好
 *
 * @Author: zhouxuan
 * @Date: 2018/5/18
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class Interview {
    private ConcurrentHashMap<File, LineStats> fileStats = new ConcurrentHashMap<>();
    private int fileCount = 0;

    public void display() {
        LineStats lineStats = new LineStats();
        while (fileCount != fileStats.size()) {
        }
        for (File file : fileStats.keySet()) {
            lineStats.merge(fileStats.get(file));
        }
        lineStats.display();
    }

    public void recurPath(String dir) throws IOException {
        File file = new File(dir);
        if (file.isDirectory()) {
            for (File filePath : file.listFiles()) {
                recurPath(filePath.getAbsolutePath());
            }
        } else if (file.isFile() && file.length() > 5 &&
                file.getName().endsWith(".java")) {
            fileCount++;
            new Thread(() -> {
                try {
                    fileStats.put(file, statsFile(file));
                } catch (IOException e) {
                    //log error msg
                }
            }).start();
        } else {
            throw new IOException(dir + "是非法的路径名");
        }
    }

    public LineStats statsFile(File file) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            LineStats lineStats = new LineStats();
            Boolean commenting = false;
            while ((line = bufferedReader.readLine()) != null) {
                lineStats.total++;
                //只包含空格的算不算空行？只包含空格和tab的呢？
                if (line.trim().equals("")) {
                    lineStats.empty++;
                }
                boolean isComment = false;
                for (int i = 0; i < line.length() - 1; i++) {
                    char c = line.charAt(i);
                    if (c != '/') {
                        continue;
                    }


                    char cl = i == 0 ? ' ' : line.charAt(i - 1);
                    char cr = line.charAt(i + 1);
                    if (commenting) {
                        isComment = true;
                    }
                    if (commenting && cl == '*') {
                        commenting = false;
                    } else if (!commenting && cr == '*') {
                        isComment = true;
                        commenting = true;
                    } else if (cr == '/') {
                        isComment = true;
                    }
                }
                if (isComment){
                    System.out.println(line);
                }
                lineStats.comment += isComment ? 1 : 0;
            }
            return lineStats;
        } catch (FileNotFoundException e) {
            //log fail
            throw e;
        } catch (IOException e) {
            //log fail
            throw e;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    private class LineStats {
        int total;
        int empty;
        int comment;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getEmpty() {
            return empty;
        }

        public void setEmpty(int empty) {
            this.empty = empty;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public void merge(LineStats lineStats) {
            this.total += lineStats.total;
            this.empty += lineStats.empty;
            this.comment += lineStats.comment;
        }

        public void display() {
            System.out.println("total:" + total);
            System.out.println("empty:" + empty);
            System.out.println("comment:" + comment);
        }
    }
}