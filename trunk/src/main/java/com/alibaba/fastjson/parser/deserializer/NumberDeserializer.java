package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.common.collect.Maps;
import com.jing.config.web.exception.ParameterException;
import com.jing.utils.PropertiesUtil;

public class NumberDeserializer implements ObjectDeserializer {

    public final static NumberDeserializer instance = new NumberDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        final JSONLexer lexer = parser.lexer;
        if (lexer.token() == JSONToken.LITERAL_INT) {
            if (clazz == double.class || clazz  == Double.class) {
                String val = lexer.numberString();
                lexer.nextToken(JSONToken.COMMA);
                return (T) Double.valueOf(Double.parseDouble(val));
            }
            
            long val = lexer.longValue();
            lexer.nextToken(JSONToken.COMMA);

            if (clazz == short.class || clazz == Short.class) {
                return (T) Short.valueOf((short) val);
            }

            if (clazz == byte.class || clazz == Byte.class) {
                return (T) Byte.valueOf((byte) val);
            }

            if (val >= Integer.MIN_VALUE && val <= Integer.MAX_VALUE) {
                return (T) Integer.valueOf((int) val);
            }
            return (T) Long.valueOf(val);
        }

        if (lexer.token() == JSONToken.LITERAL_FLOAT) {
            if (clazz == double.class || clazz == Double.class) {
                String val = lexer.numberString();
                lexer.nextToken(JSONToken.COMMA);
                return (T) Double.valueOf(Double.parseDouble(val));
            }

            BigDecimal val = lexer.decimalValue();
            lexer.nextToken(JSONToken.COMMA);

            if (clazz == short.class || clazz == Short.class) {
                return (T) Short.valueOf(val.shortValue());
            }

            if (clazz == byte.class || clazz == Byte.class) {
                return (T) Byte.valueOf(val.byteValue());
            }

            return (T) val;
        }

        Object value = parser.parse();

        if (value == null) {
            return null;
        }

        if (clazz == double.class || clazz == Double.class) {
        	Double double1;
        	try{
        		 double1 = TypeUtils.castToDouble(value);
                if(null==double1){
                	Map<String,String> errors = Maps.newHashMap();
                	errors.put((String) fieldName, PropertiesUtil.getValue("validator.number.message"));
                	throw new ParameterException(errors);
                }
                }catch (Exception e) {
                	Map<String,String> errors = Maps.newHashMap();
                	errors.put((String) fieldName, PropertiesUtil.getValue("validator.number.message"));
                	throw new ParameterException(errors);
    			}
            return (T) double1;
        }

        if (clazz == short.class || clazz == Short.class) {
            return (T) TypeUtils.castToShort(value);
        }

        if (clazz == byte.class || clazz == Byte.class) {
            return (T) TypeUtils.castToByte(value);
        }

        return (T) TypeUtils.castToBigDecimal(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
