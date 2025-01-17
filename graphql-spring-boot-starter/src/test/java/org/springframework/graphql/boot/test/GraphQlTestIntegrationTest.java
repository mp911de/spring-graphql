/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.graphql.boot.test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.test.tester.GraphQlTester;

/**
 * Integration test for {@link GraphQlTest @GraphQlTest} annotated tests.
 *
 * @author Brian Clozel
 */
@GraphQlTest(controllers = BookController.class,
		properties = {"spring.graphql.schema.locations:classpath:books/"})
public class GraphQlTestIntegrationTest {

	@Autowired
	private GraphQlTester graphQlTester;

	@Test
	void getBookdByIdShouldReturnTestBook() {
		String query = "{" +
				"  bookById(id: \"book-1\"){ " +
				"    id" +
				"    name" +
				"    pageCount" +
				"    author" +
				"  }" +
				"}";
		graphQlTester.query(query).execute()
				.path("data.bookById.id").entity(String.class).isEqualTo("42");
	}

}
