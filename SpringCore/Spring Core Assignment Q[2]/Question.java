package io.org.listProg;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
	private int questionId;
	private String question;
	private List<String> listanswers;
	private Set<String> setanswers;
	private Map<Integer,String> mapanswers;
	
	
	public Question(int questionId, String question, List<String> listanswers, Set<String> setanswers,
			Map<Integer, String> mapanswers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.listanswers = listanswers;
		this.setanswers = setanswers;
		this.mapanswers = mapanswers;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return questionId;}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;}
	public String getQuestion() {
		return question;}
	public void setQuestion(String question) {
		this.question = question;}
	public List<String> getListanswers() {
		return listanswers;}
	public void setListanswers(List<String> listanswers) {
		this.listanswers = listanswers;}
	public Set<String> getSetanswers() {
		return setanswers;}
	public void setSetanswers(Set<String> setanswers) {
		this.setanswers = setanswers;}
	public Map<Integer, String> getMapanswers() {
		return mapanswers;}
	public void setMapanswers(Map<Integer, String> mapanswers) {
		this.mapanswers = mapanswers;}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ",\n question=" + question + ",\n listanswers=" + listanswers
				+ ",\n setanswers=" + setanswers + ",\n mapanswers=" + mapanswers + "]";
	}
	
	
	
	
}
