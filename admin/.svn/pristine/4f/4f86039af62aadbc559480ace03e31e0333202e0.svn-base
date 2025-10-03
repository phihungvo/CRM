package com.base.admin.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.base.admin")
                .build();
    }


//    @Bean
//    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
//        return new SwaggerUiConfigParameters()
////                .withDefaultModelRendering(SwaggerUiConfigParameters.ModelRendering.EXAMPLE)
//                .withDeepLinking(true)
//                .withDisplayOperationId(false)
//                .withDisplayRequestDuration(false)
//                .withDocExpansion(SwaggerUiConfigParameters.DocExpansion.NONE)
//                .withFilter(false)
//                .withLayout(SwaggerUiConfigParameters.Layout.DOC)
//                .withOauth2(new SwaggerUiOAuth2ConfigParameters())
//                .withOperationsSorter(SwaggerUiConfigParameters.OperationsSorter.ALPHA)
//                .withShowExtensions(false)
//                .withShowCommonExtensions(false)
//                .withSupportHeaderParams(true)
//                .withSupportCredentials(true)
//                .withTagsSorter(SwaggerUiConfigParameters.TagsSorter.ALPHA)
//                .withUiSorter(SwaggerUiConfigParameters.UiSorter.ALPHA)
//                .withValidatorUrl(null)
//                .withWithCredentials(false)
//                .withRequestTimeout(null)
//                .withPresets(Arrays.asList(SwaggerUiConfigParameters.Preset.MOBILE, SwaggerUiConfigParameters.Preset.SUPPORTED_METHODS))
//                .withHideDownloadUrl(false)
//                .withHideDownloadButton(false)
//                .withMaxDisplayedTags(null)
//                .withOperationsSorter(SwaggerUiConfigParameters.OperationsSorter.ALPHA)
//                .withPersistAuthorization(true)
//                .withShowCommonExtensions(false)
//                .withShowExtensions(false)
//                .withSwaggerUiSupportConfig(new SwaggerUiSupportConfigParameters());
//    }
}
