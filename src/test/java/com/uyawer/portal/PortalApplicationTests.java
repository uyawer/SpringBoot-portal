/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PortalApplicationTests {

    // MEMO:(uyawer) GithubActionsでテスト失敗するので@Testを外した
    // @Test
    void hashPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
    }
}
