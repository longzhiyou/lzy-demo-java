package lzy.sys.auth.domain;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.Data;

/**
 *
 * Created by bukeyan on 2017/4/4.
 */

@Data
public class SoftSerial {

    private Long id;

    private String uuid;

    public String getUuid() {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();

        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);

        //加密为16进制字符串（Hex表示）
        String encryptHex = des.encryptHex(uuid);
        return encryptHex;
    }
}
