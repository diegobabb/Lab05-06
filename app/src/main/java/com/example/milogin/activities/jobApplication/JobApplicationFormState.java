package com.example.milogin.activities.jobApplication;

import androidx.annotation.Nullable;

public class JobApplicationFormState {
    @Nullable
    private Integer firstNameError;
    @Nullable
    private Integer lastNameError;
    @Nullable
    private Integer streetAdrrError;
    @Nullable
    private Integer streetAdrr2Error;
    @Nullable
    private Integer cityError;
    @Nullable
    private Integer provinceError;
    @Nullable
    private Integer zipError;
    @Nullable
    private Integer countryError;
    @Nullable
    private Integer emailError;
    @Nullable
    private Integer areaError;
    @Nullable
    private Integer phoneError;
    @Nullable
    private Integer dateError;

    private boolean isDataValid;

    public JobApplicationFormState() {
        this.firstNameError = null;
        this.lastNameError = null;
        this.streetAdrrError = null;
        this.streetAdrr2Error = null;
        this.cityError = null;
        this.provinceError = null;
        this.zipError = null;
        this.countryError = null;
        this.emailError = null;
        this.areaError = null;
        this.phoneError = null;
        this.dateError = null;
        this.isDataValid = false;
    }

    public JobApplicationFormState(boolean isDataValid) {
        this.firstNameError = null;
        this.lastNameError = null;
        this.streetAdrrError = null;
        this.streetAdrr2Error = null;
        this.cityError = null;
        this.provinceError = null;
        this.zipError = null;
        this.countryError = null;
        this.emailError = null;
        this.areaError = null;
        this.phoneError = null;
        this.dateError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getFirstNameError() {
        return firstNameError;
    }

    @Nullable
    public Integer getLastNameError() {
        return lastNameError;
    }

    @Nullable
    public Integer getStreetAdrrError() {
        return streetAdrrError;
    }

    @Nullable
    public Integer getStreetAdrr2Error() {
        return streetAdrr2Error;
    }

    @Nullable
    public Integer getCityError() {
        return cityError;
    }

    @Nullable
    public Integer getProvinceError() {
        return provinceError;
    }

    @Nullable
    public Integer getZipError() {
        return zipError;
    }

    @Nullable
    public Integer getCountryError() {
        return countryError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    @Nullable
    public Integer getAreaError() {
        return areaError;
    }

    @Nullable
    public Integer getPhoneError() {
        return phoneError;
    }

    @Nullable
    public Integer getDateError() {
        return dateError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    public void setFirstNameError(@Nullable Integer firstNameError) {
        this.firstNameError = firstNameError;
    }

    public void setLastNameError(@Nullable Integer lastNameError) {
        this.lastNameError = lastNameError;
    }

    public void setStreetAdrrError(@Nullable Integer streetAdrrError) {
        this.streetAdrrError = streetAdrrError;
    }

    public void setStreetAdrr2Error(@Nullable Integer streetAdrr2Error) {
        this.streetAdrr2Error = streetAdrr2Error;
    }

    public void setCityError(@Nullable Integer cityError) {
        this.cityError = cityError;
    }

    public void setProvinceError(@Nullable Integer provinceError) {
        this.provinceError = provinceError;
    }

    public void setZipError(@Nullable Integer zipError) {
        this.zipError = zipError;
    }

    public void setCountryError(@Nullable Integer countryError) {
        this.countryError = countryError;
    }

    public void setEmailError(@Nullable Integer emailError) {
        this.emailError = emailError;
    }

    public void setAreaError(@Nullable Integer areaError) {
        this.areaError = areaError;
    }

    public void setPhoneError(@Nullable Integer phoneError) {
        this.phoneError = phoneError;
    }

    public void setDateError(@Nullable Integer dateError) {
        this.dateError = dateError;
    }
}
