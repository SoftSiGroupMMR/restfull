package dk.si.restfull.classes;



public class TravelRequest {

    String customerEmail, customerName;
    boolean countryData, flightBooking, hotelBooking;
    long dateTo, dateFrom;
    String cityTo, cityFrom;
    double maxPriceHotel, maxPriceFlight;
    int numberOfGuests;

    public TravelRequest(String customerEmail, String customerName, boolean countryData, boolean flightBooking, boolean hotelBooking, long dateTo, long dateFrom, String cityTo, String cityFrom, double maxPriceHotel, double maxPriceFlight, int numberOfGuests) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.countryData = countryData;
        this.flightBooking = flightBooking;
        this.hotelBooking = hotelBooking;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.cityTo = cityTo;
        this.cityFrom = cityFrom;
        this.maxPriceHotel = maxPriceHotel;
        this.maxPriceFlight = maxPriceFlight;
        this.numberOfGuests = numberOfGuests;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCountryData() {
        return countryData;
    }

    public void setCountryData(boolean countryData) {
        this.countryData = countryData;
    }

    public boolean isFlightBooking() {
        return flightBooking;
    }

    public void setFlightBooking(boolean flightBooking) {
        this.flightBooking = flightBooking;
    }

    public boolean isHotelBooking() {
        return hotelBooking;
    }

    public void setHotelBooking(boolean hotelBooking) {
        this.hotelBooking = hotelBooking;
    }

    public long getDateTo() {
        return dateTo;
    }

    public void setDateTo(long dateTo) {
        this.dateTo = dateTo;
    }

    public long getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public double getMaxPriceHotel() {
        return maxPriceHotel;
    }

    public void setMaxPriceHotel(double maxPriceHotel) {
        this.maxPriceHotel = maxPriceHotel;
    }

    public double getMaxPriceFlight() {
        return maxPriceFlight;
    }

    public void setMaxPriceFlight(double maxPriceFlight) {
        this.maxPriceFlight = maxPriceFlight;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return "travelRequest{" +
                "customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", countryData=" + countryData +
                ", flightBooking=" + flightBooking +
                ", hotelBooking=" + hotelBooking +
                ", dateTo=" + dateTo +
                ", dateFrom=" + dateFrom +
                ", cityTo='" + cityTo + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", maxPriceHotel=" + maxPriceHotel +
                ", maxPriceFlight=" + maxPriceFlight +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}
