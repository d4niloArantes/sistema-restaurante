package fpu.si4p.t2.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
public class RelatoriosController {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = "/relatorio")
	public String mostraRelatorios()
	{
		return "Relatorios";
	}
	
	@RequestMapping("/relVendaMes")
	public ModelAndView maisVendidosMensal() 
	{
		final JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:maisConsumidosMes.jrxml");
		view.setJdbcDataSource(dataSource);
		view.setApplicationContext(appContext);
		Map<String, Object> params = new HashMap<>();
		return new ModelAndView(view, params);
	}
}
