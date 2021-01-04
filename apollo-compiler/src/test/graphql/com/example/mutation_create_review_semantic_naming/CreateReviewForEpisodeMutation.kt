// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review_semantic_naming

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.example.mutation_create_review_semantic_naming.adapter.CreateReviewForEpisodeMutation_ResponseAdapter
import com.example.mutation_create_review_semantic_naming.type.Episode
import com.example.mutation_create_review_semantic_naming.type.ReviewInput
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class CreateReviewForEpisodeMutation(
  val ep: Episode,
  val review: ReviewInput
) : Mutation<CreateReviewForEpisodeMutation.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@CreateReviewForEpisodeMutation.ep
      this["review"] = this@CreateReviewForEpisodeMutation.review
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        writer.writeString("ep", this@CreateReviewForEpisodeMutation.ep.rawValue)
        writer.writeObject("review", this@CreateReviewForEpisodeMutation.review.marshaller())
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      CreateReviewForEpisodeMutation_ResponseAdapter.fromResponse(reader)
    }
  }

  /**
   * The mutation type, represents all updates we can make to our data
   */
  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        CreateReviewForEpisodeMutation_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * Represents a review for a movie
     */
    data class CreateReview(
      /**
       * The number of stars this review gave, 1-5
       */
      val stars: Int,
      /**
       * Comment about the movie
       */
      val commentary: String?
    ) {
      fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          CreateReviewForEpisodeMutation_ResponseAdapter.Data.CreateReview.toResponse(writer, this)
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "0af665fbb1ccec4fbec377a80b620cb423b737162848a7b16b842c2fa382b54c"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation CreateReviewForEpisode(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    stars
          |    commentary
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "CreateReviewForEpisode"
      }
    }
  }
}
