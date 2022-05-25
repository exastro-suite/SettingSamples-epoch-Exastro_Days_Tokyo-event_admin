/*   Copyright 2022 NEC Corporation
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

package exastro.Exastro_Days_Tokyo.event_admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

public abstract class ServerHeaderInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected HeadersHolder headersHolder;
		
	public ServerHeaderInterceptor() {
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		Object authcHeader = request.getHeader("Authorization");
		
//		logger.debug("Check authcHeader");
		if (authcHeader != null) {
//			logger.debug("AuthcHeader Exists.");
			headersHolder.readFrom(request);
		}
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//		headersHolder.writeTo(response);
		logger.debug(headersHolder.toString());
		headersHolder.clear();
	}
}
