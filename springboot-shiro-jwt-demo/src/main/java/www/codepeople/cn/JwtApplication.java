/**
 * @Title: JwtApplication.java
 * @Package www.codepeople.cn
 * @Description: 
 * Copyright: Copyright (c) 2019 www.codepeople.cn Inc. All rights reserved. 
 * Website: www.codepeople.cn
 * 注意：本内容仅限于海南科澜技术信息有限公司内部传阅，禁止外泄以及用于其他的商业目 
 * @Author fzq
 * @DateTime 2019年7月3日 下午5:26:30
 * @version V1.0
 */

package www.codepeople.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: JwtApplication
 * @Description: 
 * @Author fzq
 * @DateTime 2019年7月3日 下午5:26:30
 */

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
}
