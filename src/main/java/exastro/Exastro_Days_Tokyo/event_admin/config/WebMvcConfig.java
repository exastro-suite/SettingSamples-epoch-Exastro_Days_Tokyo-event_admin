/*   Copyright 2021 NEC Corporation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package exastro.Exastro_Days_Tokyo.event_admin.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import exastro.Exastro_Days_Tokyo.event_admin.controller.HeadersHolder;
import exastro.Exastro_Days_Tokyo.event_admin.controller.ServerHeaderInterceptor;
import exastro.Exastro_Days_Tokyo.event_admin.repository.ClientHandlerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static final String THREAD_SCOPE = "thread";
			
	@Scope(THREAD_SCOPE)
	public @interface ThreadScope {
	};
	
	@Bean @ThreadScope
	public HeadersHolder headersHolder() {
		return new HeadersHolder();
	}
	
	@Bean
	public static CustomScopeConfigurer yourCustomScopeConfigurer() {
	  final CustomScopeConfigurer newConfigurer = new CustomScopeConfigurer();
	  Map<String, Object> newScopes = new HashMap<String, Object>();
	  newScopes.put(THREAD_SCOPE, new SimpleThreadScope());
	  newConfigurer.setScopes(newScopes);
	  return newConfigurer;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ServerHeaderInterceptor() {
			{headersHolder = headersHolder();}
		});
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
//		restTemplateBuilder.additionalInterceptors(new ClientHandlerInterceptor() {
//			{headersHolder = headersHolder();}
//		});

//		return restTemplateBuilder.build();
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}
		interceptors.add(new ClientHandlerInterceptor() {
			{headersHolder = headersHolder();}
		});
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
}
