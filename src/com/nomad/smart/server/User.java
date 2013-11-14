package com.nomad.smart.server;

import java.util.List;

public class User {

    private String userId;
    private String userName;
    private String emailId;
    private String contact;
    private List<Skill> skills;
    private List<String> travelInfoIds;
    private Vote vote;
    private List<String> comments;
    private List<String> pendingEvents;
    private List<String> rejectedEvents;
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<String> getTravelInfoIds() {
		return travelInfoIds;
	}

	public void setTravelInfoIds(List<String> travelInfoIds) {
		this.travelInfoIds = travelInfoIds;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getPendingEvents() {
		return pendingEvents;
	}

	public void setPendingEvents(List<String> pendingEvents) {
		this.pendingEvents = pendingEvents;
	}

	public List<String> getRejectedEvents() {
		return rejectedEvents;
	}

	public void setRejectedEvents(List<String> rejectedEvents) {
		this.rejectedEvents = rejectedEvents;
	}

	public List<String> getApprovedEvents() {
		return approvedEvents;
	}

	public void setApprovedEvents(List<String> approvedEvents) {
		this.approvedEvents = approvedEvents;
	}

	private List<String> approvedEvents;
    
    private static class Vote {
        private int total;
        private int positive;
        
        private Vote() {
                total = 0;
                positive = 0;
        }
        
        public int getTotal() {
                return total;
        }
        public void setTotal(int total) {
                this.total = total;
        }
        public int getPositive() {
                return positive;
        }
        public void setPositive(int positive) {
                this.positive = positive;
        }
}

}
