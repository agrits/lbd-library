package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Category;

@Path("category")
public class CategoryResource extends AbstractResource<Category>{

	@Override
	public Class<Category> getType() {
		return Category.class;
	}

}
