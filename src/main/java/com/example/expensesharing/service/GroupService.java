package com.example.expensesharing.service;

import com.example.expensesharing.entity.Group;

import com.example.expensesharing.entity.User;
import com.example.expensesharing.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
    @Transactional
    public Group addUsersToGroup(Long groupId, List<User> users) {
        Group group = groupRepository.findById(groupId).orElse(null);
        if (group != null) {
            group.getUsers().addAll(users);
            return groupRepository.save(group);
        }
        return null;
    }

    @Transactional
    public Group removeUserFromGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        if (group != null) {
            group.getUsers().removeIf(user -> user.getId().equals(userId));
            return groupRepository.save(group);
        }
        return null;
    }
}
