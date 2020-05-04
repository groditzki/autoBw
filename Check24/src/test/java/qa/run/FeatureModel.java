package qa.run;

import java.util.ArrayList;
import java.util.List;

import qa.models.Product;

public class FeatureModel {
	private FeatureModel feature;
	private String epic;
	private String keyword = "Feature: ";
	private String sprint;
	private String featureFileName;
	private String background="";
	private String name;
	private String desc ="";
	
	public String getFeatureFileName() {
		return featureFileName;
	}
	public void setFeatureFileName(String featureFileName) {
		this.featureFileName = featureFileName.replace(".feature","");
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	
	private List<ScenarioModel> scenarios = new ArrayList<ScenarioModel>();
	private ScenarioModel scenario;
	public FeatureModel getFeature() {
		return feature;
	}
	public void setFeature(FeatureModel feature) {
		this.feature = feature;
	}
	public ScenarioModel getScenario() {
		return this.scenario;
	}
	public void setScenario(ScenarioModel scenario) {
		this.scenario = scenario;
	}
	public FeatureModel(String name) {
		System.out.println("this a new feature: " + name);
		this.name = name;
	}
	public String getEpic() {
		return epic;
	}
	public void setEpic(String epic) {
		this.epic = epic;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.replaceAll("Feature:","").trim();
		setDesc(name);
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		if (this.desc.isEmpty()) {
			this.desc = desc;
		} else {
			this.desc = this.desc + "\n" + desc;
		}
	}
	public List<ScenarioModel> getScenarios() {
		return scenarios;
	}
	public void setScenarios(List<ScenarioModel> scenarios) {
		this.scenarios = scenarios;
	}
	
	public void addScenario(ScenarioModel scenario) {
		//System.out.println("add scenario: " + scenario.getDesc());
		this.scenario=scenario;
		this.scenarios.add(scenario);
	}
	public ScenarioModel getScenario(String desc) {
		for (ScenarioModel scenario : scenarios) {
			if (scenario.getDesc().equalsIgnoreCase(name)) {
				return scenario;
			}
		}
		return null;
	}
	public String getSprint() {
		return sprint;
	}
	public void setSprint(String sprint) {
		this.sprint = sprint;
	}
	
	
}
class ScenarioModel {
	private ScenarioModel scenario;
	private String id;
	private String keyword = "Scenario Outline: ";
	private String tag;
	private String desc;
	private List<StepModel> steps=new ArrayList<StepModel>();
	private String examples ="";
	public ScenarioModel(String tag,String desc) {
	
		this.tag=tag;
		this.desc=desc.trim();
	}
	public ScenarioModel(ScenarioModel scenario) {
		this.scenario= scenario;
	}
	public ScenarioModel(ScenarioModel scenario, List<StepModel> steps) {
		this.scenario= scenario;
		this.scenario.setSteps(steps);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDesc() {
		return desc.trim();
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<StepModel> getSteps() {
		return steps;
	}
	public void setSteps(List<StepModel> steps) {
		this.steps = steps;
	}
	
	public StepModel getStep(String name) {
		for (StepModel step : steps) {
			if (step.getName().equalsIgnoreCase(name)) {
				return step;
			}
		}
		return null;
	}
	public void addStep(StepModel step) {
		this.steps.add(step);
	}
	
	public void addStep(String keyword, String name) {
		this.steps.add(new StepModel(keyword,name));
	}
	public String getExamples() {
		return examples;
	}
	public void setExamples(String examples) {
		if (this.examples.isEmpty()) {
			this.examples = examples;
		} else {
			this.examples = this.examples  + "\n" +examples;
		}
	}

	
	
	
}
class StepModel {
	private String id;
	private String keyword;
	private String name;
	private String desc;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public StepModel(String keyword,String name) {
		this.keyword=keyword;
		this.name=name;
		this.id="987879";
	}
	public StepModel(String desc) {
		this.desc=desc;
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}

	
	
}
