package com.spellhaven.spring0516_1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
						
		// 공통 기능이 적용될 메소드(joinpoint)의 이름 불러오기
		String signatureStr = joinpoint.getSignature().toShortString();
		
		// joinpoint 메소드의 이름 출력, ㅋ
		System.out.println(signatureStr + "메소드가 시작되었습니다, ㅋ");	
		
		long st = System.currentTimeMillis(); // start time으로 현재 시간 가져오기(밀리초 단위)해 봤다, ㅋ.
		
		
		try {
			Object obj = joinpoint.proceed();  // joinpoint 메소드 ㄱㄱ하는 놈.
			return obj;
		} finally {
			long et = System.currentTimeMillis(); // 느그는 end time이야.
			System.out.println(signatureStr + "메소드가 종료되었디!");
			System.out.println(signatureStr + "경과 시간: " + (et - st)); // et - st 하면 이 메소드가 얼마나 실행됐는지 걸린 시간이 나옴.
		}
	
	}

	public void beforeAdvice() {
		System.out.println("beforeAdvice가 실행됨!");
	}
	
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice가 실행됨!");
	}
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice가 실행됨!");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice가 실행됨!");
	}
}
