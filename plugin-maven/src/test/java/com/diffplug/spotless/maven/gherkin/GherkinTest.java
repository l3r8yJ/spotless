/*
 * Copyright 2023 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.spotless.maven.gherkin;

import com.diffplug.spotless.maven.MavenIntegrationHarness;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GherkinTest extends MavenIntegrationHarness {
	@Test
	public void testFormatJson_WithSimple_defaultConfig_sortByKeys() throws Exception {
		writePomWithGherkinSteps("<simple/>");

		setFile("examples/main/resources/example.feature").toResource("gherkin/minimalBefore.feature");
		mavenRunner().withArguments("spotless:apply").runNoError();
		assertFile("examples/main/resources/example.feature").sameAsResource("gherkin/minimalAfter.feature");
	}

}
