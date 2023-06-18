terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  region = "ap-south-1"
}

resource "aws_instance" "Selenium_Run_Instance" {
  ami           = "ami-049a62eb90480f276"
  availability_zone = "ap-south-1a"
  security_groups = ["DevopsLearning_SG"]
  instance_type = "t2.micro"
  key_name = "DevopsLearning"

  tags = {
    Name = "HelloWorld"
  }

}

output "Selenium_Instance_IP" {
  value = aws_instance.Selenium_Run_Instance.public_ip
}