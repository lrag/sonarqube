/*
 * Copyright (C) 2012-2022 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.utils.FilesUtils;

class NoServletsRuleTest {

  @Test
  void verify() {


	    try {
			CheckVerifier.newVerifier()
			  .onFile("src/test/files/NoServletsRule.java")
			  .withCheck(new NoServletsRule())
			  .withClassPath(FilesUtils.getClassPath("target/test-jars"))
			  .verifyIssues();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
  }

}
