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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

public class HeadersHolder {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String AUTHORIZATION_KEY = "Authorization";
	
	private String authorization;
	
	private HeadersHolder(String authorization) {
		this.authorization = authorization;
	}
	
	public HeadersHolder() {
		this(null);
	}
	
	public void readFrom(HttpServletRequest request) {
		this.authorization = request.getHeader(AUTHORIZATION_KEY);
	}
	
	public void writeTo(HttpHeaders headers) {
		if(this.authorization != null) {
			headers.add(AUTHORIZATION_KEY, this.authorization);
		}
	}
	
	public void clear() {
		this.authorization = null;
	}
}
