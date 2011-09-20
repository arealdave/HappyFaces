/*
 * Copyright 2011 arealdave@gmail.com
 *
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

package com.github.happyfaces.component;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.junit.Test;

import com.github.happyfaces.mock.jsf.MockResponseWriter;

public class HelloWorldRendererTest {

	@Test
	public void testEncodeNoGreeting() throws IOException {
		FacesContext context = mock(FacesContext.class);
		MockResponseWriter mwr = new MockResponseWriter();
		when(context.getResponseWriter()).thenReturn(mwr);
		HelloWorldRenderer hwr = new HelloWorldRenderer();
		hwr.encodeBegin(context, null);
		
		assertEquals(mwr.getResponse(), "<div style=\"color: red\">HelloWorld stranger</div>");
		
		
	}

	@Test
	public void testEncodeGreeting() throws IOException {
		FacesContext context = mock(FacesContext.class);
		MockResponseWriter mwr = new MockResponseWriter();
		when(context.getResponseWriter()).thenReturn(mwr);
		HelloWorldRenderer hwr = new HelloWorldRenderer();
		HelloWorldComponent hwc = new HelloWorldComponent();
		hwc.setGreeting("everyone");
		hwr.encodeBegin(context, hwc);
		
		assertEquals(mwr.getResponse(), "<div style=\"color: red\">HelloWorld everyone</div>");
	}
}
