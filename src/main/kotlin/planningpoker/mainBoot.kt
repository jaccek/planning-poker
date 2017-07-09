package planningpoker

import org.hibernate.SessionFactory
import org.hibernate.cfg.AvailableSettings
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import planningpoker.hibernatetest.MyApplication
import java.util.*
import javax.sql.DataSource

@SpringBootApplication(exclude = arrayOf(HibernateJpaAutoConfiguration::class))
@ComponentScan("planningpoker")
open class Application

@Configuration
//@ComponentScan("planningpoker")
open class ApplicationConfiguration : WebMvcConfigurerAdapter() {

    @Bean
    open fun localeResolver(): LocaleResolver {
        val resolver = SessionLocaleResolver()
        resolver.setDefaultLocale(Locale.US)
        return resolver
    }

    @Bean
    open fun localeChangeInterceptor(): LocaleChangeInterceptor {
        val interceptor = LocaleChangeInterceptor()
        interceptor.paramName = "lang"
        return interceptor
    }

    override fun addInterceptors(registry: InterceptorRegistry?) {
        super.addInterceptors(registry)
        registry?.addInterceptor(localeChangeInterceptor())
    }
}

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
open class HibernateConfig {

    @Autowired
    private lateinit var env: Environment

    @Bean
    open fun getDataSource(): DataSource =
            DriverManagerDataSource().apply {
                setDriverClassName(env.getRequiredProperty("datasource.driver"))
                url = env.getRequiredProperty("datasource.url")
                username = env.getRequiredProperty("datasource.username")
                password = env.getRequiredProperty("datasource.password")
            }

    @Bean
    open fun getSessionFactory(): LocalSessionFactoryBean =
            LocalSessionFactoryBean().apply {
                setDataSource(getDataSource())
                setPackagesToScan("planningpoker.model.hibernate")
                hibernateProperties = this@HibernateConfig.getHibernateProperties()
            }

    private fun getHibernateProperties() =
            Properties().apply {
                put(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"))
                put(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql"))
                put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,
                        env.getRequiredProperty("hibernate.current.session.context.class"))
            }

    @Bean
    open fun getTransactionManager(sessionFactory: SessionFactory): HibernateTransactionManager =
            HibernateTransactionManager(sessionFactory)

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)

//    var context: AnnotationConfigApplicationContext? = null
//
//    try {
//        context = AnnotationConfigApplicationContext(ApplicationConfiguration::class.java)
//        val application = context.getBean(MyApplication::class.java)
//        application.performDbTasks()
//    } catch (e: Exception) {
//        e.printStackTrace()
//    } finally {
//        context?.close()
//    }
}
