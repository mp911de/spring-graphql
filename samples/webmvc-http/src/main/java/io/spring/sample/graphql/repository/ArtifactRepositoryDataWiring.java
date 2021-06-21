package io.spring.sample.graphql.repository;

import graphql.schema.idl.RuntimeWiring;

import org.springframework.graphql.boot.RuntimeWiringCustomizer;
import org.springframework.graphql.data.QuerydslDataFetcherSupport;
import org.springframework.stereotype.Component;

@Component
public class ArtifactRepositoryDataWiring implements RuntimeWiringCustomizer {

	private final ArtifactRepositories repositories;

	public ArtifactRepositoryDataWiring(ArtifactRepositories repositories) {
		this.repositories = repositories;
	}

	@Override
	public void customize(RuntimeWiring.Builder builder) {
		builder.type("Query",
				typeWiring -> typeWiring.dataFetcher("artifactRepositories", QuerydslDataFetcherSupport
						.builder(repositories).many())
						.dataFetcher("artifactRepository", QuerydslDataFetcherSupport
						.builder(repositories).single()));
	}

}
