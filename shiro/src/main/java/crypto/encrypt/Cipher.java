package crypto.encrypt;

/**
 * Created by zhouxuan on 16/7/4.
 */
public interface Cipher<P, C> {
    C encryptor(P plain);

    P decryptor(C cipher);
}
