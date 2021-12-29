package com.spring.demo;


import lombok.*;

import javax.annotation.Resource;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CarServiceAuto implements ICarService{

	@Resource(name="car2")  // DI by annotaion
	Car car; //xml에서 car2인거 자동으로 연결~!

	@Override
	public void coloring(String color) {
		car.setColor(color);
		System.out.println( "coloring auto : "  + car.toString()  );
	}

	@Override
	public void washing() {
		System.out.println( "washing auto : "  + car.toString()  );
	}
}
