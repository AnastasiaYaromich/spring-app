package ru.yaromich.spring.repositories;

import ru.yaromich.spring.entities.FileMetaDTO;

import java.util.Collection;
import java.util.UUID;

public interface IFileMetaProvider {

    String checkFileExists(UUID fileHash);

    /**
     * Сохранить метаданные файла
     *
     */
    void saveFileMeta(UUID Hash, String fileName, int sybType);

    Collection<FileMetaDTO> getMetaFiles(int subtype);
}