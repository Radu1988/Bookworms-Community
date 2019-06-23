package ro.sci.bookwormscommunity.web.dto;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ro.sci.bookwormscommunity.model.User;
import ro.sci.bookwormscommunity.validators.ValidPhoto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.FileInputStream;

public class BookDto {
    @NotEmpty
    @Size(min=2, max=100)
    private String bookName;
    @NotEmpty
    @Size(min=2, max=100)
    private String authorName;
    @Min(value = 20)
    @Max(value = 9999)
    private int numberOfPages;
    @NotEmpty
    private String type;
    @NotEmpty
    private String language;
    @NotEmpty
    private String description;
    private String condition;
    private boolean bookRent;
    private boolean bookSale;
    private double sellPrice;
    private double rentPrice;
    @ValidPhoto(message = "Profile picture must be a .jpg/.jpeg/.png file and must not exceed 1MB.")
    private MultipartFile photo;

    private User user;

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isBookRent() {
        return bookRent;
    }

    public void setBookRent(boolean bookRent) {
        this.bookRent = bookRent;
    }

    public boolean isBookSale() {
        return bookSale;
    }

    public void setBookSale(boolean bookSale) {
        this.bookSale = bookSale;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public MultipartFile returnPhoto() throws Exception {
        if (photo.isEmpty()) {
            return new MockMultipartFile("book.png", new FileInputStream(new File("src/main/resources/static/images/book.png")));
        }
        return photo;
    }
}
