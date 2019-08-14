package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Survey;

@Path("survey")
public class SurveyResource extends AbstractResource<Survey>{

	@Override
	public Class<Survey> getType() {
		return Survey.class;
	}

}
