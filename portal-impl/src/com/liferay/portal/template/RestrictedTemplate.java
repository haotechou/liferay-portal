/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.template;

import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateException;

import java.io.Writer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tina Tian
 */
public class RestrictedTemplate implements Template {

	public RestrictedTemplate(
		Template template, List<String> restrictedVariables) {

		_restrictedVariables = restrictedVariables;
		_template = template;
	}

	public Object get(String key) {
		return _template.get(key);
	}

	public void prepare(HttpServletRequest request) throws TemplateException {
		_template.prepare(request);
	}

	public boolean processTemplate(Writer writer) throws TemplateException {
		return _template.processTemplate(writer);
	}

	public void put(String key, Object value) {
		if (_restrictedVariables.contains(key)) {
			return;
		}

		_template.put(key, value);
	}

	List<String> _restrictedVariables;
	Template _template;

}