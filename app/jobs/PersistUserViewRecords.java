package jobs;

import evn.PubParam;
import play.Play;
import play.jobs.Every;
import play.jobs.Job;

@Every("2mn")
public class PersistUserViewRecords extends Job {
	
	@Override
	public void doJob() throws Exception {
		super.doJob();
		if(Play.mode.isProd()) {
			PubParam.AutoPersistViewRecord();
		}
	}
}