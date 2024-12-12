package com.example.vamojossa.models;

import com.example.vamojossa.utils.DateTimeUtils;
import com.example.vamojossa.utils.RegexUtils;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import com.example.vamojossa.presenters.TableDataPresenter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: organize this code, for Gaga's sake
public class Movement implements TableDataPresenter.TableDataAdapter {

        private final SimpleObjectProperty<LocalDate> date_info = new SimpleObjectProperty<>();
        private final SimpleObjectProperty<LocalTime> time_info = new SimpleObjectProperty<>();
        private final SimpleStringProperty account = new SimpleStringProperty();
        private final SimpleStringProperty category = new SimpleStringProperty();
        private final SimpleStringProperty subcategory = new SimpleStringProperty();
        private final SimpleStringProperty note = new SimpleStringProperty();
        private final SimpleFloatProperty amount = new SimpleFloatProperty();
        private final SimpleStringProperty description = new SimpleStringProperty();

        public LocalDate getDate_info() {
                return date_info.get();
        }

        public SimpleObjectProperty<LocalDate> date_infoProperty() {
                return date_info;
        }

        public void setDate_info(LocalDate date_info) {
                this.date_info.set(date_info);
        }

        public String getAccount() {
                return account.get();
        }

        public SimpleStringProperty accountProperty() {
                return account;
        }

        public void setAccount(String account) {
                this.account.set(account);
        }

        public String getCategory() {
                return category.get();
        }

        public SimpleStringProperty categoryProperty() {
                return category;
        }

        public void setCategory(String category) {
                this.category.set(category);
        }

        public String getSubcategory() {
                return subcategory.get();
        }

        public SimpleStringProperty subcategoryProperty() {
                return subcategory;
        }

        public void setSubcategory(String subcategory) {
                this.subcategory.set(subcategory);
        }

        public String getNote() {
                return note.get();
        }

        public SimpleStringProperty noteProperty() {
                return note;
        }

        public void setNote(String note) {
                this.note.set(note);
        }

        public float getAmount() {
                return amount.get();
        }

        public SimpleFloatProperty amountProperty() {
                return amount;
        }

        public void setAmount(float amount) {
                this.amount.set(amount);
        }

        public String getDescription() {
                return description.get();
        }

        public SimpleStringProperty descriptionProperty() {
                return description;
        }

        public void setDescription(String description) {
                this.description.set(description);
        }

        @Override
        public String[] asRow() {
                return new String[]{this.description.get(), this.date_info.get().toString(), String.valueOf(this.amount)};
        }

        @Override
        public List<String> getTableHeaders() {
                return List.of("Description", "Date", "Amount");
        }

        /*
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */

        /**
         *
         * This function builds a Nubank Movement from a csv line
         *
         * @param csv_str: single line from CSV file that represents a single Nubank movement
         * @return : Movement that represents the data from the CSV line
         */
        public static Movement fromNubankCSV(String csv_str) {

                String separator = ",";

                String[] entries = csv_str.split(separator);


                Movement new_movement = new Movement();


                //TODO: NubankMovement doesn't export the time of movements, it must be added by user input
                new_movement.setDate_info(
                        LocalDate.parse(entries[NubankCSVColumns.DATE], DateTimeUtils.DIRECT_FORMAT)
                );

                new_movement.setAmount(Float.parseFloat(entries[NubankCSVColumns.AMOUNT]));

                new_movement.setDescription(entries[NubankCSVColumns.DESCRIPTION]);

                return new_movement;
        }

        /*
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */

        public static boolean validateNubankCSVLine(String str){

                Pattern p = Pattern.compile(String.join(",", RegexUtils.date_pattern_str, RegexUtils.float_pattern_str, "[a-z0-9-]*", ".*"));

                Matcher m = p.matcher(str);

                return m.matches();
        }
}
