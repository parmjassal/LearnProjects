package org.learn.ds.segmentTree;

import java.util.Objects;

public class SumOperation<T extends Number> implements AssociativeOperation<T>{

	
	@Override
	public T operate(T a, T b) throws InvalidOperandException{
		// TODO Auto-generated method stub
		if(a==null)
			a = getIdentityObject();
		if(b==null)
			b = getIdentityObject();
		
		Type typeA = Type.getType(a.getClass().getName());
		Type typeB = Type.getType(b.getClass().getName());
		
		if(Objects.isNull(typeA) || Objects.isNull(typeB) || typeA != typeB)
			throw new InvalidOperandException("Operands are not valid");
		
		return (T) typeA.operate(a, b);	
	}
	


	@Override
	public T getIdentityObject() {
		// TODO Auto-generated method stub
		return (T)Type.getIdentity();
	}
	
	
	enum Type{
		
		Float(Float.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (float)a+(float)b;
			}
		},
		Integer(Integer.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (int)a+(int)b;
			}
		},
		Double(Double.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (double)a+(double)b;
			}
		},
		Long(Long.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (long)a+(long)b;
			}
		},
		Byte(Byte.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (byte)a+(byte)b;
			}
		},
		Short(Short.class.getName()){
			@Override
			public Object operate(Object a, Object b) {
				// TODO Auto-generated method stub
				return (short)a+(short)b;
			}
		};
		
		private String type;
		
		private Type(String type) {
			this.type = type;
		}
		
		public Object operate(Object a,Object b) {
			return null;
		}
		
		static Type getType(String className) {
			for(Type type:Type.values())
			{
				if(type.type.equals(className))
					return type;
			}
			
			return null;
		}
		
		static Object getIdentity() {
			return 0;
		}
		
	}
	
}
