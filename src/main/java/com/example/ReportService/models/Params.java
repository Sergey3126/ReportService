package com.example.ReportService.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Params {
    private List<UUID> accounts;
    private List<UUID> category;
    private LocalDateTime from;
    private LocalDateTime to;

    public List<UUID> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<UUID> accounts) {
        this.accounts = accounts;
    }

    public List<UUID> getCategory() {
        return category;
    }

    public void setCategory(List<UUID> category) {
        this.category = category;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Params{" +
                "account=" + accounts +
                ", category=" + category +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    public Params(List<UUID> category, List<UUID> account, LocalDateTime from, LocalDateTime to) {
        this.category = category;
        this.accounts = account;
        this.from = from;
        this.to = to;
    }

    public Params() {
    }
}
