CREATE TABLE `company` (
	`id` bigint(20) NOT NULL,
	`cnpj` VARCHAR (255) NOT NULL,
	`date_creation` datetime NOT NULL,
	`date_update` datetime NOT NULL,
	`company_name` VARCHAR (255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
	`id` bigint(20) NOT NULL,
	`cpf` VARCHAR (255) NOT NULL,
	`date_creation`  datetime NOT NULL,
	`date_update` datetime NOT NULL,
	`company_name` VARCHAR (255) NOT NULL,
	`name` VARCHAR (255) NOT NULL,
	`profile` VARCHAR (255) NOT NULL,
	`email` VARCHAR (255) NOT NULL,
	`amount_of_hour_worked` FLOAT DEFAULT NULL,
	`amount_of_lunch_time` FLOAT DEFAULT NULL,
	`password` VARCHAR(255) NOT NULL,
	`hour_value` DECIMAL(19,2) DEFAULT NULL,
	`company_id` BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;	

CREATE TABLE `launch` (
	`id` bigint(20) NOT NULL,
	`cnpj` VARCHAR (255) NOT NULL,
	`description` datetime NOT NULL,
	`date_update` datetime NOT NULL,
	`company_name` VARCHAR (255) NOT NULL,
	`location` VARCHAR (255) NOT NULL,
	`type` VARCHAR (255) NOT NULL,
	`employee_id` BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk4cm1kg523jlopyexjbmi6y54j` (`company_id`);

--
-- Indexes for table `lancamento`
--
ALTER TABLE `launch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK46i4k5vl8wah7feutye9kbpi4` (`employee_id`);

--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `company`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lancamento`
--
ALTER TABLE `launch`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `funcionario`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK4cm1kg523jlopyexjbmi6y54j` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `lancamento`
--
ALTER TABLE `launch`
  ADD CONSTRAINT `FK46i4k5vl8wah7feutye9kbpi4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);
