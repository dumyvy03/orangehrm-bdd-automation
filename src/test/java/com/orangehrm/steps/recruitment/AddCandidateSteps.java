package com.orangehrm.steps.recruitment;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.recruitment.AddCandidatePO;
import com.orangehrm.pages.recruitment.CandidateProfilePO;
import com.orangehrm.pages.recruitment.CandidatesPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class AddCandidateSteps {
    private CandidatesPO candidatePage;
    private AddCandidatePO addCandidatePage;
    private String firstName, lastName, email, contactNumber, resume, vacancy, keywords, dateOfApplication, notes;
    private CandidateProfilePO candidateProfilePage;

    public AddCandidateSteps() {
        candidatePage = PageGenerator.getCandidatesPage(DriverFactory.getDriver());
    }

    @And("clicks the Add button to open the Add Candidate page")
    public void clickOpenAddCandidatePage() {
        addCandidatePage = candidatePage.clickAddButton();
    }

    @And("the admin enters the candidate's information:")
    public void enterCandidateInformation(DataTable dataTable) {
        Map<String, String> addCandidateData = dataTable.asMap(String.class, String.class);
        firstName = addCandidateData.get("First Name");
        lastName = addCandidateData.get("Last Name");
        vacancy = addCandidateData.get("Vacancy");
        email = addCandidateData.get("Email");
        contactNumber = addCandidateData.get("Contact Number");
        resume = addCandidateData.get("Resume");
        keywords = addCandidateData.get("Keywords");
        notes = addCandidateData.get("Notes");

        addCandidatePage.enterCandidateInformation(addCandidateData);
    }

    @And("clicks the Save button to create the new candidate")
    public void clickSaveNewCandidate() {
        dateOfApplication = addCandidatePage.getDateOfApplicationValue();
        candidateProfilePage = addCandidatePage.clickSaveButton();
    }

    @Then("the Candidate Profile page displays the candidate’s details")
    public void verifyCandidateSDetailsDisplayed() {
        Assert.assertEquals(candidateProfilePage.getFirstNameValue(), firstName);
        Assert.assertEquals(candidateProfilePage.getLastNameValue(), lastName);
        Assert.assertEquals(candidateProfilePage.getJobVacancyText(), vacancy);
        Assert.assertEquals(candidateProfilePage.getEmailValue(), email);
        Assert.assertEquals(candidateProfilePage.getContactNumberValue(), contactNumber);
        Assert.assertEquals(candidateProfilePage.getUploadedResumeFileName(), resume);
        Assert.assertEquals(candidateProfilePage.getKeywordsValue(), keywords);
        Assert.assertEquals(candidateProfilePage.getDateOfApplicationValue(), dateOfApplication);
        Assert.assertEquals(candidateProfilePage.getNotesValue(), notes);
    }

    @When("the admin enters the email {string}")
    public void enterEmail(String email) {
        addCandidatePage.enterEmailTextbox(email);
    }

    @Then("the Add Candidate email field displays the error {string}")
    public void verifyEmailErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getEmailErrorMessage(), errorMessage);
    }

    @When("the admin uploads the resume file {string}")
    public void uploadResumeFile(String resume) {
        addCandidatePage.uploadResumeFile(resume);
    }

    @Then("the Add Candidate resume field displays the error {string}")
    public void verifyResumeErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getResumeErrorMessage(), errorMessage);
    }

    @When("the admin enters the contact number {string}")
    public void enterContactNumber(String contactNumber) {
        addCandidatePage.enterContactNumberTextbox(contactNumber);
    }

    @Then("the Add Candidate contact number field displays the error {string}")
    public void verifyContactNumberErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addCandidatePage.getContactNumberErrorMessage(), errorMessage);
    }


}
