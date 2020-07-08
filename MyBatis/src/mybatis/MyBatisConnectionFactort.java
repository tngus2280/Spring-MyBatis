package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	// SqlSession 객체를 생성하는 팩토리객체
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		//마이바티스 Configuration XML 파일의 경로
		String res = "mybatis/mybatis-config.xml";
		
		try {
			//Configuration XML 파일을 이용한 입력 스트림 생성
			Reader reader = Resources.getResourceAsReader(res);
			
			//싱글톤 유지 코드
			if(sqlSessionFactory == null) {
				
				// 빌더가 입력스트림생성한것을 읽어서 팩토리를 만들어준다
				// 입력스트림으로 읽은 설정파일을 이용한 SqlSessionFactory 객체 생성
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//private 생성자
	private MyBatisConnectionFactory() {}
	
	//싱글톤 객체 반환 메소드
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
		
	}	
}
