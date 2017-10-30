/*
 * Copyright 2017. the original author is eumji, email: eumji025@gmail.com.
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

package com.eumji.stream;

import com.eumji.stream.config.sink.SinkApplicationDemo;
import com.eumji.stream.config.source.SourceApplication;
import com.eumji.stream.config.transform.ProcessApplicaiton;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.aggregate.AggregateApplicationBuilder;

@SpringBootApplication
public class SpringCloudStreamDoubleUseApplication {

	public static void main(String[] args) {
		new AggregateApplicationBuilder(SpringCloudStreamDoubleUseApplication.class, args)
				.from(SourceApplication.class).args("--fixedDelay=5000")
				.via(ProcessApplicaiton.class)
				.to(SinkApplicationDemo.class).args("--debug=true").run();
	}
}