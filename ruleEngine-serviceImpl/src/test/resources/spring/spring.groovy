import com.alibaba.druid.pool.DruidDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager

beans{

    xmlns context: "http://www.springframework.org/schema/context"
    xmlns tx: "http://www.springframework.org/schema/tx"


    propertyPlaceholderConfigurer(PropertyPlaceholderConfigurer){
        locations=["datasource.properties"]
        fileEncoding="UTF-8"
    }

    context.'annotation-config'()
    context.'component-scan'('base-package': "com.engine.service")

    dataSource(DruidDataSource){
        driverClassName="com.mysql.cj.jdbc.Driver"
        url='jdbc:mysql://10.88.75.139:3306/test_db?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false'
        username='user'
        password="111111"
    }

    dataSourceTransactionManager(DataSourceTransactionManager){
        dataSource : ref dataSource
    }

    sqlSessionFactory(SqlSessionFactory){
        dataSource ref: dataSource
        mapperLocations="classpath*:com/engine/dao/sqlMap/*Map.xml"
    }

    (MapperScannerConfigurer){
        basePackage="com.engine.dao"
        sqlSessionFactoryBeanName="sqlSessionFactory"
    }

    groovyEngine(GroovyScriptEngineImpl){

    }

    pathMatchingResourcePatternResolver(PathMatchingResourcePatternResolver){

    }

    importBeans "../spring-dubbo-provider.xml"
}