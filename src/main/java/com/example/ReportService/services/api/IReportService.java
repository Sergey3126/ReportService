package com.example.ReportService.services.api;

import com.example.ReportService.models.Params;
import com.example.ReportService.models.Report;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IReportService {
    /**
     * Создает отчет по параметрам
     *
     * @param type      тип отчета
     * @param paramsRaw тело отчета с category(Нужные категории), accounts(Нужные операции), from(с какого числа), to(по какое число)
     * @return созданный отчет
     */
    Report createReport(String type, Params paramsRaw);

    /**
     * Дает отчеты
     *
     * @param page номер страницы(больше 0)
     * @param size кол-во объектов на странице(размер страницы, больше 0)
     * @return список операций
     */
    PageImpl<Report> getReport(int page, int size);

    /**
     * Выгружает результат в виде excel
     *
     * @return excel файл
     */
    ResponseEntity<ByteArrayResource> exportReport(UUID uuid);

    /**
     * Дает статус отчета
     *
     * @return статус
     */
    ResponseEntity<Void> statusReport(UUID uuid);
}
