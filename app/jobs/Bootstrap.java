package jobs;

import java.util.List;

import models.DBCategory;
import models.DBPubInfo;
import models.DBSource;
import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {

	/**
	 * 启动的时候做几件事情：
	 * 1、初始化数据
	 * 2、没想到，以后需要再补充
	 */
	@Override
	public void doJob() throws Exception {
		Logger.info("init data check..");
		
		initData();
		if(Play.mode.isDev()) {
			new SyncWeidianItem().doJob();
		}
		Logger.info("check complete..");
		
//		SyncWeidianItem.rangeSyncItemIds();
	}
	
	/**
	 * 启动的时候初始化数据：
	 * 1、商品的公共参数数据
	 * 2、商品的分类数据
	 * 3、商品数据来源数据
	 */
	public static void initData() {
		DBPubInfo dbp = DBPubInfo.all().first();
		if(dbp == null) {
			Logger.info("init pubinfo..");
			new DBPubInfo(12).save();
		}
		
		List<DBSource> sourceList = DBSource.all().fetch();
		if(sourceList.size() == 0) {
			Logger.info("init source..");
			new DBSource("weidian").save();
		}
		
		List<DBCategory> categoryList = DBCategory.all().fetch();
		if(categoryList.size() == 0) {
			Logger.info("init category..");
			new DBCategory("9块9包邮").save();
		}
	}
}
