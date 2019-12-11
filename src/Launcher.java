import dao.DaoManager;
import dao.paper.PaperDao;
import dao.paper.PaperDaoImp;
import dao.question.QuestionDao;
import dao.question.QuestionDaoImp;
import model.Paper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import service.ChangePasswordService;
import service.ChangePasswordServiceImpl;
import service.DoExamService;
import service.DoExamServiceImpl;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class Launcher extends HttpServlet
{
	private static final long serialVersionUID = -3436651019725988874L;
	private static Log log = LogFactory.getLog(Launcher.class);

	public void init() throws ServletException
	{
		super.init();

		try
		{
			log.info("启动系统...");

			Context context = new javax.naming.InitialContext();
			log.info("1");
			context = (Context) context.lookup("java:comp/env");

			log.info("2");
			// 初始化各种管理器
			DaoManager.initialize((DataSource) context.lookup("jdbc/esql"));

			
			log.info("启动系统完毕！");
		}
		catch (Exception e)
		{
			log.fatal("启动系统失败！", e);

			throw new ServletException("启动系统失败: " + e.getMessage(), e);
		}
	}

}
