package com.example.ReportService.controllers.rest;

import com.example.ReportService.models.Params;
import com.example.ReportService.models.Report;
import com.example.ReportService.services.api.IReportService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ReportController {
    private IReportService reportService;

    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * Создает отчет по параметрам
     *
     * @param type      тип отчета
     * @param paramsRaw тело отчета с category(Нужные категории), accounts(Нужные операции), from(с какого числа), to(по какое число)
     * @return созданный отчет
     */
    @PostMapping(value = {"report/{type}", "report/{type}/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Report createReport(@PathVariable("type") String type, @RequestBody Params paramsRaw) {
        return reportService.createReport(type, paramsRaw);
    }

    /**
     * Дает отчеты
     *
     * @param page номер страницы(больше 0)
     * @param size кол-во объектов на странице(размер страницы, больше 0)
     * @return список операций
     */

    @GetMapping(value = {"report/{page}/{size}", "report/{page}/{size}/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<Report> getReport(@PathVariable int page, @PathVariable int size) {
        return reportService.getReport(page, size);
    }

    /**
     * Выгружает результат в виде excel
     *
     * @return excel файл
     */
    @GetMapping(value = {"account/{uuid}/export", "account/{uuid}/export/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ByteArrayResource> exportReport(@PathVariable UUID uuid) {
        return reportService.exportReport(uuid);
    }

    /**
     * Дает статус отчета
     *
     * @return статус
     */
    @RequestMapping(value = {"account/{uuid}/export", "account/{uuid}/export/"}, method = RequestMethod.HEAD)
    public ResponseEntity<Void> statusReport(@PathVariable UUID uuid) {
        return reportService.statusReport(uuid);
    }
}

