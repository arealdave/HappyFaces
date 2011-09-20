package com.github.happyfaces.mock.jsf;

import javax.el.ELContext;
import javax.el.ValueExpression;

public class MockStringValueExpression extends ValueExpression {

	
	@Override
	public Class<?> getExpectedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getType(ELContext arg0) {
		return String.class;
	}

	@Override
	public Object getValue(ELContext arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReadOnly(ELContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(ELContext arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getExpressionString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLiteralText() {
		// TODO Auto-generated method stub
		return false;
	}

}
