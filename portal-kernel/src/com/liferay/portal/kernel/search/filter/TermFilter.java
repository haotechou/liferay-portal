/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.search.filter;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Michael C. Han
 */
public class TermFilter extends BaseFilter {

	public TermFilter(String field, String value) {
		_field = field;
		_value = value;
	}

	@Override
	public <T> T accept(FilterVisitor<T> filterVisitor) {
		return filterVisitor.visit(this);
	}

	public String getField() {
		return _field;
	}

	@Override
	public int getSortOrder() {
		return 3;
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{(");
		sb.append(_field);
		sb.append("=");
		sb.append(_value);
		sb.append("), ");
		sb.append(super.toString());
		sb.append("}");

		return sb.toString();
	}

	private final String _field;
	private final String _value;

}