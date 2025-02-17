package com.example.movementsprocessor.models.movement;

import com.example.movementsprocessor.presenters.TableDataPresenter;

import java.util.List;
import java.util.Objects;

public class MovementBuilder implements TableDataPresenter.TableDataAdapter {

        private String date_info;
        private String time_info;
        private String account;
        private float amount;
        private String description;


        public void addAmountInfo(float amount) {

                this.amount += amount;
        }

        public void addDescription(String description) {

                this.description = description;
        }


        public void addDateInfo(String date_info) {

                this.date_info = date_info;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                MovementBuilder that = (MovementBuilder) o;
                return Float.compare(amount, that.amount) == 0 && Objects.equals(date_info, that.date_info) && Objects.equals(time_info, that.time_info) && Objects.equals(account, that.account) && Objects.equals(description, that.description);
        }

        @Override
        public int hashCode() {
                return Objects.hash(date_info, time_info, account, amount, description);
        }

        @Override
        public String[] asRow() {
                return new String[]{this.description, this.date_info, String.valueOf(this.amount)};
        }

        @Override
        public List<String> getTableHeaders() {
                return List.of("Description", "Date", "Amount");
        }
}
