import React, { useEffect, useState } from 'react';

const Employeetable = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    const fetchEmployees = async () => {
      const response = await fetch('/employees');
      const data = await response.json();
      setEmployees(data);
    };
    fetchEmployees();
  }, []);

  return (
    <table className="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Surname</th>
          <th>Email</th>
          <th>Gender</th>
          <th>Department</th>
        </tr>
      </thead>
      <tbody>
        {employees.map((employee) => (
          <tr key={employee.id}>
            <td>{employee.firstName}</td>
            <td>{employee.lastName}</td>
            <td>{employee.email}</td>
            <td>{employee.gender}</td>
            <td>{employee.department}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default Employeetable;
