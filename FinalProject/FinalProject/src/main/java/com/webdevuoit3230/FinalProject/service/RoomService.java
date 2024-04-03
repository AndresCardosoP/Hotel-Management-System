package com.webdevuoit3230.FinalProject.service;

import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
