package com.webdevuoit3230.FinalProject.service;

import com.webdevuoit3230.FinalProject.model.Room;
import com.webdevuoit3230.FinalProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Room> findRoomByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public Room saveRoom(Room room) {
        // Check if a room with the given number already exists
        Optional<Room> existingRoom = findRoomByRoomNumber(room.getRoomNumber());
        if (existingRoom.isPresent()) {
            throw new IllegalArgumentException("Room number " + room.getRoomNumber() + " already exists.");
        }
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
