package com.cn.periodical.enums;

import org.springframework.core.convert.converter.Converter;

public class CertificatesTypeEnumsConverter implements Converter<String, CertificatesTypeEnums>{

	public CertificatesTypeEnumsConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CertificatesTypeEnums convert(String source) {
		// TODO Auto-generated method stub
		String value = source.trim();
	    if ("".equals(value)) {
	      return null;
	    }
	    return CertificatesTypeEnums.get(source);
	}
}
