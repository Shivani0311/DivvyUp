package com.example.expensesharing.controller;

import com.example.expensesharing.entity.Group;

import com.example.expensesharing.entity.User;
import com.example.expensesharing.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id, @RequestBody Group group) {
        group.setId(id);
        return groupService.saveGroup(group);
    }
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }

    @PostMapping("/{groupId}/users")
    public Group addUsersToGroup(@PathVariable Long groupId, @RequestBody List<User> users) {
        return groupService.addUsersToGroup(groupId, users);
    }

    @DeleteMapping("/{groupId}/users/{userId}")
    public Group removeUserFromGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        return groupService.removeUserFromGroup(groupId, userId);
    }
}
