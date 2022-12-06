/*
 * Copyright 2002-2022 the original author or authors.
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

package org.springframework.graphql.data.query.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.graphql.data.query.QueryByExampleDataFetcher.Builder;
import org.springframework.graphql.data.query.QueryByExampleDataFetcher.QueryByExampleBuilderCustomizer;
import org.springframework.graphql.data.query.jpa.QueryByExampleDataFetcherJpaTests.BookDto;

@GraphQlRepository
public interface ProjectingBookJpaRepository extends JpaRepository<Book, Long>, QueryByExampleBuilderCustomizer<Book> {

	@Override
	default Builder<Book, ?> customize(Builder<Book, ?> builder){
		return builder.projectAs(BookProjection.class);
	}
}
